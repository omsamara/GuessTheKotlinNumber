import java.util.*

/**
 * Created by osamara on 6/9/17.
 */

private val RANDOM = Random()
var randomNum: Int = -1
var playerGuess: Int = -1
var playAgain: String? = "Yes"

fun main(args: Array<String>) {
    println()
    println("Hello and welcome to the number guessing game!")
    println()
    println("The game works by choosing a random number from 1-100 and telling you if your guess was" +
             "higher or lower than the random number generated")
    println()
    println("Let's begin. I've got my number.")

    genRandomNum()

    while(playerGuess != randomNum && playAgain == "Yes") {
        playGame()
    }



}

fun playGame() {
    println("What's your guess?")
    println()

    try {

        /**
         * This line is to avoid NullPointerExceptions
         * it checks if readLine is null, if it is then playerGuess will be set to -1
         * if it is not null then playerGuess will be set to readLine().toInt()
         * ?: is known as the elvis expression
         */
        playerGuess = readLine()?.toInt() ?: -1
    }
    catch(e: Exception) {
        println("You've entered in something wrong. Please try again")
        return playGame()
    }

    println()

    if (playerGuess < randomNum)
        println("Your guess is lower than the number")
    else if (playerGuess > randomNum)
        println("Your guess is higher than the number")
    else {
        println("Congrats! You've guessed the correct number")
        println("Would you like to play again?")

        playAgain = readLine()

        // The user does want to play again so a new random number is generated and the user's value is set to -1
        if(playAgain == "Yes") {
            genRandomNum()

            //Setting the value to -1 avoids the (uncommon) issue of the new random number being the same as
            //the user's last guess
            playerGuess = -1
        }
    }
}

fun genRandomNum() {
    randomNum = RANDOM.nextInt(100) + 1
}

