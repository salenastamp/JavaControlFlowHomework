package homework;

import java.util.Scanner;

public class AsciiChars {
	public static void printNumbers() {
		for (int i = 48; i < 58; i++) {
			String n = Character.toString((char) i);
			System.out.println(n);
		}

	};

	public static void printLowerCase() {
		for (int i = 97; i < 123; i++) {
			String n = Character.toString((char) i);
			System.out.println(n);
		}
	};

	public static void printUpperCase() {
		for (int i = 65; i < 91; i++) {
			String n = Character.toString((char) i);
			System.out.println(n);
		}
	};

	public static void getLotto() {
		Scanner userInput = new Scanner(System.in);
		String car;
		do {
			System.out.println("Great! Do you have a red car? yes/no?");
			car = userInput.nextLine();
		} while ((!car.equals("yes") && (!car.equals("y")) && (!car.equals("no")) && (!car.equals("n"))));

		String petName;
		do {
			System.out.println("What is your pet's name? *must be at least 3 letters long*");
			petName = userInput.nextLine();
		} while ((petName.length() < 3));

		String petAgeString;
		do {
			System.out.println("How old is " + petName + "?");
			petAgeString = userInput.nextLine();
		} while (!petAgeString.matches(".*\\d.*"));
		int petAge = Integer.parseInt(petAgeString);

		String luckyNumberString;
		do {
			System.out.println("What is your lucky number?");
			luckyNumberString = userInput.nextLine();
		} while (!luckyNumberString.matches(".*\\d.*"));
		int luckyNumber = Integer.parseInt(luckyNumberString);

		String qbyn;
		String qbNumString;
		do {
			System.out.println("Do you have a favorite Quarterback? yes/no");
			qbyn = userInput.nextLine();
			if (qbyn.equals("yes")) {
				do {
					System.out.println("What is their jersey number?");
					qbNumString = userInput.nextLine();
				} while (!qbNumString.matches(".*\\d.*"));
				int qbNum = Integer.parseInt(qbNumString);
			}
		} while (!qbyn.equals("yes") && (!qbyn.equals("no")) && (!qbyn.equals("y") && (!qbyn.equals("n"))));

		String modelYearString;
		do {
			System.out.println("What is the two-digit model year of your car?");
			modelYearString = userInput.nextLine();
		} while (!modelYearString.matches(".*\\d.*"));
		int modelYear = Integer.parseInt(modelYearString);

		String favActor;
		do {
			System.out.println("What is the first name of your favorite actor of any gender?");
			favActor = userInput.nextLine();
		} while ((favActor.length() < 1));

		String userNumberString;
		int userNumber;
		do {
			do {
				System.out.println("Give me a number between 1 and 50");
				userNumberString = userInput.nextLine();
			} while ((!userNumberString.matches(".*\\d.*")));
			userNumber = Integer.parseInt(userNumberString);
		} while ((userNumber < 1 || userNumber > 50));

		int min = 0;
		int max = 5;
		int random1 = (int) (Math.random() * (max - min + 1) + min);
		int random2 = (int) (Math.random() * (max - min + 1) + min);
		int random3 = (int) (Math.random() * (max - min + 1) + min);

		int magicBall = luckyNumber * random1;
		while (magicBall > 75) {
			magicBall = magicBall - 75;
		}

		int lotto1 = modelYear + luckyNumber;
		int lotto2 = 42;
		int lotto3 = petAge + modelYear;
		char firstAct = favActor.charAt(0);
		int lotto4 = firstAct;
		char thirdPet = petName.charAt(2);
		int lotto5 = thirdPet;

		System.out.printf("Lottery Numbers: %s, %s, %s, %s, %s Magic Ball: %s", lotto1, lotto2, lotto3, lotto4, lotto5,
				magicBall);
		userInput.close();
	}

	public static void wannaPlay() {
		Scanner userInput = new Scanner(System.in);
		String answer1;
		System.out.println("What is your name?");
		String name = userInput.nextLine();
		do {
			System.out.println("Hello " + name + "! Do you want to keep talking and get your lottery numbers? yes/no?");
			answer1 = userInput.nextLine();
			if (answer1.equals("yes") || answer1.equals("y")) {
				getLotto();
				System.out.println("\r Would you like to answer the questions again for new lotto numbers? yes/no?");
				String answer2 = userInput.nextLine();
				if (answer2.equals("yes")) {
					getLotto();
				} else {
					System.out.println("Thank you for playing!");
				}
			} else if (answer1.equals("no") || answer1.equals("n")) {
				System.out.println("That's ok. Please come back later to continue the survey.");
			}
		} while ((!answer1.equals("yes")) && (!answer1.equals("no")));
		userInput.close();
	}

	public static void main(String[] args) {
		System.out.println("Valid Characters are as follows:");
		printNumbers();
		printLowerCase();
		printUpperCase();
		wannaPlay();

	}

}
