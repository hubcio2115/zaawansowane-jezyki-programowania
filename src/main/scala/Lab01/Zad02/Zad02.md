# Zadanie 2

Zdefiniuj klasę C, która będzie reprezentowała liczby zespolone.

- klasa powinna zawierać pola re i im reprezentujące część rzeczywistą i
  urojoną liczby.

- zdefiniuj odpowiednie konstruktory
  - konstruktor główny: dzięki któremu, będzie można przypisać wartości części
    rzeczywistej i urojonej, tworząc obiekt.

  - konstruktor pomocniczy: dzięki któremu, będzie można przypisać jedynie
    wartość części rzeczywistej, tworząc obiekt.

- reprezentacja tekstowa obiektów klasy, powinna być bardziej czytelna:
  - dla b > 0: a + bi
  - dla b < 0: a – bi
  - dla b = 0: a

- powinna zawierać metody:
  - `+(that: C): C`
  - `-(that: C): C`
  - `\*(that: C): C`

  które umożliwią wykonanie operacji arytmetycznych na liczbach zespolonych.

- powinna zawierać metodę: `/(that: C): C`

  która umożliwi wykonanie operacji arytmetycznej na liczbach zespolonych.
  jeżeli podany argument będzie powodował dzielenie przez 0, powinien zostać
  uruchomiony wyjątek `IllegalArgumentException`. wywołaj metodę i obsłuż
  odpowiednio wyjątek.

- obiekty klasy, powinny mieć możliwość wykonywania operacji arytmetycznych ze
  w zwykłymi liczbami rzeczywistymi.

  Przykładowo powinny działać operacje:

  ```scala
  5.3 + C(2.1, 3.5)
  C(2.2, 3.4) * 2.5
  ```

- obiekty klasy, powinny mieć możliwość wykonywania operatorów logicznych:
  `==`, `!=`, `<`, `>`, `<=`, `>=` na liczbach zespolonych. Orzyjmij, że
  operatory są zgodne z odległością od współrzędnej (0, 0) na osi Re, Im.
  wykorzystaj cechę `Ordered[A]`, albo metodę equals, tam gdzie to możliwe.
