package characters;

import body.BodyPart;
import items.Clothing;
import body.Injury;
import items.MedicalKit;
import roles.Role;
import roles.Severity;
import roles.WoundStatus;

public class Doctor extends Shorty {
    private MedicalKit medicalKit;
    private boolean isTreating;

    public Doctor(String name, Role role, Clothing clothing, MaxHealth startHealth) {
        super(name, role, clothing, startHealth);
        this.medicalKit = new MedicalKit();
        this.isTreating = false;
    }

    public void go(Shorty target) {
        System.out.println(name + " бросился к " + target.getName() + " со своей аптечкой.");
    }

    public void treat(Shorty target) {
        if (target.isInjured()) {
            isTreating = true;
            System.out.println(name + " начал лечить " + target.getName());
            stopBleeding(target);
            applyBandage(target);
            isTreating = false;
        }
    }

    public void stopBleeding(Shorty target) {
        target.wound().heal();
        System.out.println(name + " остановил кровотечение у " + target.getName());
    }

    public void applyBandage(Shorty target) {
        if (target.wound() != null) {
            // Уменьшаем боль до следующего уровня (например, от "жгучая" до "сильная")
            WoundStatus currentPain = target.wound().getPain();
            WoundStatus reducedPain = switch (currentPain) {
                case BURNING -> WoundStatus.STRONG;
                case STRONG -> WoundStatus.ACHING;
                default -> WoundStatus.ACHING; // Минимальный уровень боли
            };
            target.wound().reducePain(reducedPain);
            System.out.println(name + " наложил повязку на рану " + target.getName());
        } else {
            System.out.println("У " + target.getName() + " нет ран для наложения повязки.");
        }
    }

    public void evaluateInjury(Shorty target) {
        if (!target.isInjured() || target.wound() == null) {
            System.out.println(name + " осмотрел " + target.getName() + " и не обнаружил ран.");

        }

        // Получаем данные о ране
        BodyPart bodyPart = target.wound().getBodyPart();
        Severity severity = target.wound().getSeverity();
        WoundStatus pain = target.wound().getPain();

        // Выводим информацию о ране
        System.out.println(name + " оценил ранение у " + target.getName() + ":");
        System.out.println("- Рана на " + bodyPart.getName() + ".");
        System.out.println("- Тяжесть: " + severity);
        System.out.println("- Уровень боли: " + pain);

        String recommendation = "";
        if (severity == Severity.LIGHT) {
            recommendation = "Рекомендуется небольшая перевязка.";
        } else if (severity == Severity.MEDIUM) {
            recommendation = "Необходимо остановить кровотечение и наложить повязку.";
        } else if (severity == Severity.HEAVY) {
            recommendation = "Требуется экстренное медицинское вмешательство!";
        }

        System.out.println("- Рекомендации: " + recommendation);

    }


}
