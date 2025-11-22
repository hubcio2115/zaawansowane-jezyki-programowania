package Lab05

def countChars(str: String): Int =
  str
    .groupBy(identity)
    .keys
    .filter(char => char.isLetter)
    .toList
    .length;
