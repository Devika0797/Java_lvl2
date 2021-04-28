package homework1;

public class Main {

//+1.Создайте три класса Человек, Кот, Робот, которые не наследуются от одного класса.
//Эти классы должны уметь бегать и прыгать (методы просто выводят информацию о действии в консоль).
//+2.Создайте два класса: беговая дорожка и стена, при прохождении через которые, участники должны
//выполнять соответствующие действия (бежать или прыгать), результат выполнения печатаем в консоль
//(успешно пробежал, не смог пробежать и т.д.).
//+3.Создайте два массива: с участниками и препятствиями, и заставьте всех участников пройти этот
//набор препятствий.
//+4.* У препятствий есть длина (для дорожки) или высота (для стены), а участников ограничения на бег
//и прыжки. Если участник не смог пройти одно из препятствий, то дальше по списку он препятствий не идет.

    public static void main(String[] args) {

        RunableJumpable[] members = { // массив из бегунов и прыгунов
                new Human("Человек", 50, 2),
                new Cat("Кот", 30, 1),
                new Robot("Робот", 100, 10)
        };

        Obstacable[] obstacles = { // массив из препятствий, макс величина
                new Treadmill("Беговая дорожка", 70),
                new Wall("Стена", 2)
        };

        System.out.println("Прохождение препятствий!");

        for (RunableJumpable member : members) {
            System.out.println(member + " должен преодолеть стену и беговую дорожку.");
            boolean winner = true;
            for (Obstacable obstacle : obstacles) {
                if (obstacle.getRun(member.getMaxLength()) ||
                        obstacle.getJump(member.getMaxHeight())) {
                    System.out.println(member + " пробует пройти " + obstacle + ".\n"+ member + " смог преодолеть препятствие!");
                } else {
                    winner = false;
                    System.out.println(member + " пробует пройти " + obstacle + ".\n"+ member + " не смог преодолеть препятствие!");
                    break;
                }
            }

            if(winner) {
                System.out.println(member + " успешно прошёл дистанцию!");
            } else {
                System.out.println(member + " проиграл.");
            }
            System.out.println();



        }
    }
}
