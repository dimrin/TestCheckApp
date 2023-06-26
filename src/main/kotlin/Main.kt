fun main() {

    val stringToCheck =
        "C makes it easy for you to shoot yourself in the foot. C++ makes that harder, but when you do, it blows away your whole leg. (с) Bjarne Stroustrup"
    val stringToCheckWithoutPunct = stringToCheck.replace("\\p{Punct}".toRegex(), "") // delete all punctuation marks

    val listOfWords = stringToCheckWithoutPunct.split(" ")
    // create a list of words from the string [C, makes, it, easy, for, you, to, shoot, yourself, in, the, foot, C, makes, that, harder, but, when, you, do, it, blows, away, your, whole, leg, с, Bjarne, Stroustrup]

    val listOfChars: MutableList<Char> = mutableListOf() // create empty list to collect chars

    for (words in listOfWords) {
        val index = findIndexOfFirstUniqueChar(words)
        if (index != -1) {
            listOfChars.add(words[index])
        }
    }

    val stringOfChars: String =
        listOfChars.joinToString("") // create from list of char a string to check for unique one {CmiefytsyitfCmhhbwydibwywlсBS}


    val index = findIndexOfFirstUniqueChar(stringOfChars)
    if (index != -1) {
        println(stringOfChars[index]) // return the first unique symbol in string of chars
    }

}


fun findIndexOfFirstUniqueChar(string: String): Int {

    string.forEachIndexed { index, char ->
        if (string.indexOf(char) == string.lastIndexOf(char)) {
            return index
        }
    }

    return -1
}

