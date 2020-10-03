package z_dodatno01SingletonPattern;

public class Main {

	public static void main(String[] args) {
		Logger.get().logInfoMsg("Hello, welcome to the world of design patterns!");

		Logger.get().logWarningMsg("Be warned, it's really a cool thing, this design patterns!");
		Logger.get().logWarningMsg("And you should really study them and try applying them in you projects!");
		
		Logger.get().logErrorMsg("Don't be discouraged if you encounter some error along the way.");
		Logger.get().logInfoMsg("It simply means you are learning new things, which is always cool!");

		Logger.get().logWarningMsg("While you should know how to implement a logger, you should prefer "
				+ "using some time tested class that's already implemented instead of reinventing the wheel :)");
		
		Logger.get().logInfoMsg("Fasten your seat belt and good luck on your ride!");
		
		System.out.println("\n\nFull log:\n" + Logger.get().getFullLogData());
	}

}
