package vitalkrilov.itmo.prog.lab4;

import vitalkrilov.itmo.prog.lab4.entities.*;
import vitalkrilov.itmo.prog.lab4.exceptions.CharacteristicAlreadyExistsException;
import vitalkrilov.itmo.prog.lab4.exceptions.InventoryOverflowError;
import vitalkrilov.itmo.prog.lab4.exceptions.SlotAlreadyInUseException;
import vitalkrilov.itmo.prog.lab4.items.*;
import vitalkrilov.itmo.prog.lab4.others.*;
import vitalkrilov.itmo.prog.lab4.world.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Entry point of App.
 *
 */
public class App {

    private int overallPlayedTimes = 0;

    /*

    — Они аплодировали мне, — прошептала она про себя. — О, как я счастлива! Я буду всегда, всегда вот так счастлива!
    На следующее утро были разосланы театральные афиши.
    Птицы летали над заливом и сбрасывали театральные плакатики.
    Красочные афиши (их нарисовали Хомса и Мюмла) кружились над лесом, над берегом, над лугами, над водой, над
    крышами домов и садами.
    Одна афиша, покружив над тюрьмой, упала к ногам Хемуля.
    Он сидел и дремал на солнышке, натянув полицейскую фуражку на лоб.
    Хемуль тотчас заподозрил, что это было тайное послание узникам, и цепко схватил листок.
    Как раз сейчас у него под замком сидело не меньше трех узников, а больше у него никогда не бывало с тех пор,
    как он стал надзирателем тюрьмы.
    Уже около двух лет ему не доводилось никого стеречь, и понятно, почему он так боялся за своих подопечных.

    */

    class Story {

        private int totalDaysPassed = 0;

        private void playStory() {
            int daysPassed = 0;
            StoryPlayer.resetStory();
            daysPassed += StoryPlayer.playFirstIndependentPart(daysPassed);
            daysPassed += StoryPlayer.playSecondIndependentPart(daysPassed);
            totalDaysPassed = daysPassed + 1; // Finishing unfinished day (parts must not end increasing the day, by the way)
            ++overallPlayedTimes;
        }

        private static class StoryPlayer {
            private static final int DAYS_IN_YEAR = 365;
            private static final int DAYS_SINCE_HEMULEN_WAS_WARDENING_LAST_TIME = 2 * DAYS_IN_YEAR;
            
            private static void resetStory() {
                Date.setStoryStartDayNumber(1 + DAYS_SINCE_HEMULEN_WAS_WARDENING_LAST_TIME);
            }

            private static int playFirstIndependentPart(int daysPassed) {
                System.out.printf("Пусть история началась в день №%d.%n", Date.getStoryStartDayNumber());
                Location someUnknownScene = new Location(LocationType.SOME_UNKNOWN_SCENE);

                class UnknownPublic implements Movable {

                    private Location currentLocation;
                    private String nameAlias;

                    private static final String defaultNameAlias = "Неизвестная_публика";

                    public UnknownPublic(Location loc, String nameAlias) {
                        this.currentLocation = loc;
                        this.nameAlias = nameAlias;
                    }

                    public void applaud(Human human) {
                        System.out.printf("%s аплодирует человеку %s.%n", this.toString(), human.toString());
                    }

                    @Override
                    public Location getCurrentLocation() {
                        return this.currentLocation;
                    }

                    @Override
                    public void setCurrentLocation(Location loc) {
                        this.currentLocation = loc;
                    }

                    public String getNameAlias() {
                        return this.nameAlias;
                    }

                    public void setNameAlias(String nameAlias) {
                        this.nameAlias = nameAlias;
                    }

                    @Override
                    public boolean equals(Object o) {
                        if (this == o) return true;
                        if (o == null || this.getClass() != o.getClass()) return false;
                        //if (!super.equals(o)) return false;
                        UnknownPublic o2 = (UnknownPublic) o;
                        return Objects.equals(this.currentLocation, o2.currentLocation) && Objects.equals(this.nameAlias, o2.nameAlias);
                    }

                    @Override
                    public int hashCode() {
                        return Objects.hash(super.hashCode(), this.currentLocation, this.nameAlias);
                    }

                    @Override
                    public String toString() {
                        return String.format("%s { местоположение=%s }", this.nameAlias.isEmpty() ? defaultNameAlias : String.format("\"%s\" <%s>", this.nameAlias, defaultNameAlias), this.currentLocation.toString());
                    }

                }
                Human unknownFemale = new Human(someUnknownScene, "Она") {
                    // nothing special...
                };

                UnknownPublic unknownPublic = new UnknownPublic(someUnknownScene, "Они");
                unknownPublic.applaud(unknownFemale);

                unknownFemale.whisper("Они аплодировали мне.");
                unknownFemale.feel(FeelingType.HAPPINESS);
                unknownFemale.think("О, как я счастлива! Я буду всегда, всегда вот так счастлива!");

                return daysPassed;
            }

            private static int playSecondIndependentPart(int daysPassed) {
                ++daysPassed;
                System.out.printf("Наступил следующий день истории (день №%d).%n", Date.getStoryStartDayNumber() + daysPassed);

                // Set up locations for posters
                List<Location> postersLocations = new ArrayList<>();
                for (LocationType lt : new LocationType[]{LocationType.FOREST, LocationType.BAY, LocationType.MEADOW, LocationType.WATER, LocationType.GARDEN}) {
                    postersLocations.add(new Location(lt));
                }
                postersLocations.add(new House(HouseLocationType.ROOF));
                Location jail = new Location(LocationType.JAIL);

                Bird b = new Bird(new Location(LocationType.BAY));

                // Create posters
                int numOfPosters = postersLocations.size() * 2; //NOTE: Let it be 2 * num of locations
                int postersPerLocation = (int) Math.ceil((float) numOfPosters / postersLocations.size());
                System.out.printf("Пусть было второстепенных %d постеров, по %d в каждую нужную локацию.%n", numOfPosters, postersPerLocation);
                List<Poster> posters = new ArrayList<Poster>();
                for (Location l : postersLocations) {
                    for (int i = 0; i < postersPerLocation; ++i) {
                        Poster p = new Poster(PosterType.THEATRICAL, l);
                        p.setColorful(true); // All except special posters?.. (because it's not stated in text)
                        posters.add(p);
                    }
                }
                Poster specialBirdsPoster = new Poster(PosterType.THEATRICAL, b.getCurrentLocation());
                specialBirdsPoster.setStoryNameAlias("Плакат");
                posters.add(specialBirdsPoster);
                Poster specialJailPoster = new Poster(PosterType.THEATRICAL, jail);
                posters.add(specialJailPoster);
                // Assign authors
                for (Poster p : posters) {
                    p.addAuthor("Хомса");
                    p.addAuthor("Мюмля");
                }

                Sender s = new Sender();
                Date postersSendDate = new Date(DayPart.MORNING, Date.getStoryStartDayNumber() + daysPassed);
                for (Poster p : posters) {
                    s.scheduleSending(p, postersSendDate);
                }

                b.flyAround();
                b.dropItem(specialBirdsPoster);

                for (Poster p : posters) {
                    if (p == specialBirdsPoster) continue; // Skip dropped poster
                    p.spinInAirAround();
                }

                //specialJailPoster.spinInAirAround(); // Could be spinned here but it's already spinned with others
                DirectPosition hemulenPos = new DirectPosition("Где-то у тюрьмы на солнышке (около ног Хемуля)");
                Hemulen h = new Hemulen(hemulenPos);
                h.setProfession(ProfessionType.PRISON_WARDEN);
                {
                    HemulenPersonalRecords hemulenPersonalRecords = h.getHemulenPersonalRecords();
                    hemulenPersonalRecords.maxPrisonersCountAtSameTime = 3;
                    hemulenPersonalRecords.lastCompletedWardening = new Date(DayPart.NIGHT, Date.getStoryStartDayNumber() + daysPassed - (DAYS_SINCE_HEMULEN_WAS_WARDENING_LAST_TIME + daysPassed));
                }
                specialJailPoster.fallTo(h.getCurrentLocation());
                h.sit();
                WorldsWeatherTypesStorage wwts = new WorldsWeatherTypesStorage();
                wwts.setWeather(hemulenPos, WeatherType.SUNNY);
                System.out.println("Погода около " + h.toString() + " в данных момент " + wwts.getWeather(hemulenPos) + ".");
                h.sleep();
                WearableItem wi = new WearableItem(WearableItemType.CAP);
                wi.addCharacteristic(ItemCharacteristic.POLICE); // not need to handle since we'd just created it
                try {
                    h.wear(OnBodyPosition.FOREHEAD, wi);
                } catch (SlotAlreadyInUseException e) {
                    System.out.println("Хемуль попытался надеть шапку, но он вспомнил, что у него уже была надета другая.");
                }
                Message msg = new Message("[Некое тайное послание...]");
                msg.registerReceivers(new ReceiversGroup(ReceiversGroupType.PRISONERS)); // not need to handle since we'd just created it
                h.suspect(msg);
                try {
                    h.take(specialJailPoster);
                } catch (InventoryOverflowError e) {
                    System.out.printf("Хемуль попытался взять %s, но было некуда положить.%n", specialBirdsPoster.toString());
                }

                List<Prisoner> currentPrisoners = new ArrayList<>();
                {
                    final int CURRENT_PRISONERS_COUNT = 4; // Let this value be "not less than 3"...
                    for (int i = 0; i < CURRENT_PRISONERS_COUNT; ++i) {
                        Prisoner p = new Prisoner(jail);
                        p.setName("Узник №" + String.valueOf(i+1));
                        currentPrisoners.add(p);
                    }
                }

                {
                    HemulenPersonalRecords hemulenPersonalRecords = h.getHemulenPersonalRecords();
                    hemulenPersonalRecords.maxPrisonersCountAtSameTime = Math.max(hemulenPersonalRecords.maxPrisonersCountAtSameTime, currentPrisoners.size());
                    if (hemulenPersonalRecords.maxPrisonersCountAtSameTime == currentPrisoners.size())
                        System.out.printf("Больше узников (%d) у Хемуля никогда не бывало с тех пор, как он стал надзирателем тюрьмы.%n", hemulenPersonalRecords.maxPrisonersCountAtSameTime);
                }
                System.out.printf("Сидело %d узников.%n", currentPrisoners.size());

                for (Prisoner p : currentPrisoners)
                    p.sit();

                System.out.printf("Уже около %d дней ему не доводилось никого стеречь.%n", Date.getStoryStartDayNumber() + daysPassed - h.getHemulenPersonalRecords().lastCompletedWardening.getDayNumber());

                h.feel(FeelingType.FEAR, "Хемуль боялся за своих подопечных.");

                return daysPassed;
            }
        }
    }

    public static void main(String[] args) {
        System.out.print("Initializing App... ");
        {
            App app = new App();
            System.out.println("Done.");
            System.out.print("Creating Story... ");
            {
                Story story = app.new Story();
                System.out.println("Done.");
                System.out.println("Now playing it.");
                story.playStory();
                System.out.printf("Story lasted for %d days.%n", story.totalDaysPassed);
            }
            System.out.printf("Played story %d times. Exiting...%n", app.overallPlayedTimes);
        }
    }

}
