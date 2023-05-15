package dungeon.listeners;

import dungeon.Dungeon;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SecondsCounter implements ActionListener {
    int seconds;
    public SecondsCounter(int seconds) {
        this.seconds = seconds;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        seconds++;

        if (Dungeon.character != null){

            Dungeon.character.setTime(seconds);}



    }


}
