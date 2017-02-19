package moteur;

import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Synthesizer;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Instru {

    private Synthesizer synthesizeur;
    private MidiChannel canal;
    private int volume;

    public Instru() {

        try {
            synthesizeur = MidiSystem.getSynthesizer();
            synthesizeur.open();
        } catch (MidiUnavailableException e) {
            Logger.getLogger(Instru.class.getName()).log(Level.SEVERE, null, e);
        }

        volume = 100;
        canal = synthesizeur.getChannels()[0];
        canal.programChange(0);

    }

    public Synthesizer getSynthesizeur() {
        return synthesizeur;
    }

    public void setSynthesizeur(Synthesizer synthesizeur) {
        this.synthesizeur = synthesizeur;
    }

    public MidiChannel getCanal() {
        return canal;
    }

    public void setCanal(MidiChannel canal) {
        this.canal = canal;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    /**
     * Joue la note dont le numéro est en paramètre
     * @param note
     */
    public void noteOn(int note) {
        canal.noteOn(note, volume);
    }

    /**
     * Arrète de jouer la note dont le numéro est en paramètre
     * @param note
     */
    public void noteOff(int note) {
        canal.noteOff(note);
    }

    /**
     * Permet de changer le typede l'instrument
     * @param instru
     */
    public  void setInstrument(int instru) {
        canal.programChange(instru);
    }

}
