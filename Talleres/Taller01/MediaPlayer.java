public class MediaPlayer {
    private int volume;
    private boolean isPlaying;

    public MediaPlayer() {
        this.volume = 50; 
        this.isPlaying = false;
    }

    public int getVolume() { return volume; }
    public boolean getPlaybackState() { return isPlaying; }

    public void play() {
        this.isPlaying = true;
    }

    public void stop() {
        this.isPlaying = false;
    }

    public boolean volumeUp() {
        if (volume + 5 <= 100) {
            volume += 5;
            return true;
        }
        volume = 100; // Tope
        return false; // Retorna falso si no pudo subir 5 completos
    }

    public boolean volumeDown() {
        if (volume - 5 >= 0) {
            volume -= 5;
            return true;
        }
        volume = 0; // Tope inferior
        return false; 
    }
}