# language: nl
Functionaliteit: Uren berekening

  bij   9   8   8   8   8 0 0  verwacht ik 0 uren overwerk
  bij   12  8   8   8   8 0 0  verwacht ik geen lunchvergoeding
  bij   0   0   0   0   0 7 7  verwacht ik 30 euro lunch
  bij   8   8   8   8   8 1 0  verwacht ik 1 uur overgewerkt, geen vergoeding voor overwerk uren en 15 euro lunch geld


  Scenario: Een medewerker logt in en vult zijn of haar uren in. De vergoeding moet corresponderen met de verwachting
    Stel Ik ben ingelogd als medewerker met schaal 10
    Als Ik voor week 41 mijn uren voor maandag t/m zondag invoer
    Dan Berekend het systeem de correcte lunch en overwerk vergoeding

  Abstract Scenario: Een medewerker vult verscheidene weken in.
    Stel Ik ben ingelogd als medewerker met schaal <schaal>
    En Ik wil voor week "<week>" mijn uren invullen
    Als Ik "<maandag>" uren voor maandag invul
    En Ik "<dinsdag>" uren voor dinsdag invul
    En Ik "<woensdag>" uren voor woensdag invul
    En Ik "<donderdag>" uren voor donderdag invul
    En Ik "<vrijdag>" uren voor vrijdag invul
    En Ik "<zaterdag>" uren voor zaterdag invul
    En Ik "<zondag>" uren voor zondag invul
    Dan Dien ik het formulier in
    En Verwacht ik dat de lunch vergoeding "<lunchvergoeding>" bedraagt
    En De vergoeding voor het overwerken "<overwerkvergoeding>" bedraagt
    En Het totale bedrag op "<totaal>" uitkomt

    Voorbeelden:
      | schaal | week | maandag | dinsdag | woensdag | donderdag | vrijdag | zaterdag | zondag | lunchvergoeding | overwerkvergoeding | totaal |
      | 10     | 15   | 9       | 8       | 8        | 8         | 8       | 0        | 0      | 0               | 0                  | 0      |
      | 10     | 8    | 8       | 8       | 8        | 8         | 8       | 1        | 0      | 15              | 0                  | 15     |
      | 10     | 32   | 12      | 8       | 8        | 10        | 8       | 0        | 0      | 0               | 30                 | 30     |
      | 10     | 21   | 0       | 0       | 0        | 0         | 0       | 7        | 7      | 30              | 0                  | 30     |
      | 10     | 42   | 13      | 8       | 8        | 8         | 8       | 2        | 2      | 45              | 120                | 165    |
      #| 11     | 43   | 8       | 8       | 8        | 8         | 8       | 6        | 0      | 15              | 0                  | 15     |