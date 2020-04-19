# Numbers to text service
This project considered to provide the way of memorising arbitrary numbers transforming them to
easy-to-remember sentence.
The algorithm is based on one-to-one relation between digit and pair of letters.
Valuable are only consonants.
Russian transformation table:

Digit | Letters
-----|-------
1 | Г, Ж
2 | Д, Т
3 | К, Х
4 | Ч, Щ
5 | П, Б
6 | Ш, Л
7 | З, С
8 | В, Ф
9 | Р, Ц
0 | Н, М

## Examples
Number | Mnemonic
-------|-------
123    | ГуДоК
00036  | МаННая КаШа
8679267643 | В ЛеСу РоДиЛаСь еЛоЧКа

Any word has only one numerical representation unlike numbers that may have few.

For example the word "кошка" can be represented **only** like 3(к)6(ш)3(к)

However the number 363 may have few words to represent: КуЛаК, КаЛьКа, КоШКа,...

This project was developed as test task for GameSys

## Start project
To build the project open it in Intellij IDEA and run buildDocker gradle task.

RSS Reader requires 11th java. So to be able to build it within command line ./gradlew buildDocker, you should have 11th java
in JAVA_HOME.

To start instance run `./start.sh`