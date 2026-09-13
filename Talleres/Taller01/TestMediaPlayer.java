public class TestMediaPlayer {
    public static void main(String[] args) {
        MediaPlayer player = new MediaPlayer();
        System.out.println("Volumen inicial: " + player.getVolume() + " | Reproduciendo: " + player.getPlaybackState());

        player.play();
        System.out.println("Dar Play. Reproduciendo: " + player.getPlaybackState());

        player.volumeUp();
        player.volumeUp();
        System.out.println("Subir volumen 2 veces. Volumen: " + player.getVolume());

        // Forzar límite superior
        for (int i = 0; i < 15; i++) {
            player.volumeUp();
        }
        System.out.println("Intentar subir por encima de 100. Volumen limite: " + player.getVolume());

        // Forzar límite inferior
        for (int i = 0; i < 25; i++) {
            player.volumeDown();
        }
        System.out.println("Intentar bajar por debajo de 0. Volumen limite: " + player.getVolume());
    }
}