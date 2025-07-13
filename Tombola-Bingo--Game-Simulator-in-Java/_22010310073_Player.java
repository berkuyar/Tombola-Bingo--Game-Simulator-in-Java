
public class _22010310073_Player {
    private String name;
    private _22010310073_Card card;

    public _22010310073_Player(String name, _22010310073_Card card) {
        this.name = name;
        this.card = card;
    }

    public String getName() {
        return name;
    }

    public _22010310073_Card getCard() {
        return card;
    }

    public String displayStatus() {
        return name + " " + card.displayCard();
    }
}
