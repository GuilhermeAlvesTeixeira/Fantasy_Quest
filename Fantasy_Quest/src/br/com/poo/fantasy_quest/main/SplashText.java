package br.com.poo.fantasy_quest.main;

public enum SplashText {

    DARKNESS_AWAITS("Darkness awaits..."),
    THE_ADVENTURE_BEGINS("The adventure begins!"),
    ENTER_THE_DUNGEON("Enter the dungeon."),
    A_HERO_IS_BORN("A hero is born."),
    THE_KINGDOM_NEEDS_YOU("The kingdom needs you!"),
    BEWARE_THE_NIGHT("Beware the night..."),
	_DONT_FORGET_TO_SAVE("Don't forget to save."),
	_WHERE_IS_MY_SWORD("Where is my sword?"),
	_THE_MERCHANT_IS_WATCHING("The merchant is watching."),
	_WATCH_OUT_FOR_SLIMES("Watch out for slimes!"),
	_THIS_DUNGEON_LOOKS_FAMILIAR("This dungeon looks familiar..."),
	_ANOTHER_DUNGEON("Another dungeon..."),
	_JUST_ONE_MORE_QUEST("Just one more quest."),
	_I_SHOULD_HAVE_BOUGHT_POTIONS("I should have bought potions."),
	_THE_CHEST_WAS_EMPTY("The chest was empty."),
	_YOU_DIED("You probably won't die."),
	_NOTHING_COULD_GO_WRONG("Nothing could go wrong."),
	_WHAT_COULD_GO_WRONG("What could go wrong?"),
	_THIS_IS_FINE("This is fine."),
	_LOW_ON_HEALTH("Low on health."),
	_CHECK_YOUR_INVENTORY("Check your inventory."),
	_DID_YOU_LOCK_THE_DOOR("Did you lock the door?"),
	_THE_PRINCESS_IS_SOMEWHERE("The princess is somewhere."),
	_WHY_ARE_THERE_SO_MANY_DUNGEONS("Why are there so many dungeons?"),
	_ONE_MORE_ROOM("Just one more room."),
	_GOOD_LUCK("Good luck, hero."),
	_YOU_WILL_NEED_IT("You'll need it.");

    private final String text;

    SplashText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}