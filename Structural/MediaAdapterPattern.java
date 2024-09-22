
// MediaAdapterPattern.java
interface MediaPlayer {
    void play(String filename);
}

class Mp3Player implements MediaPlayer {
    @Override
    public void play(String filename) {
        System.out.println("Playing mp3 file: " + filename);
    }
}

class Mp4Player {
    public void playMp4(String filename) {
        System.out.println("Playing mp4 file: " + filename);
    }
}

class VlcPlayer {
    public void playVlc(String filename) {
        System.out.println("Playing vlc file: " + filename);
    }
}

class MediaAdapter implements MediaPlayer {
    private Mp4Player mp4Player;
    private VlcPlayer vlcPlayer;

    public MediaAdapter(String mediaType) {
        if (mediaType.equalsIgnoreCase("mp4")) {
            mp4Player = new Mp4Player();
        } else if (mediaType.equalsIgnoreCase("vlc")) {
            vlcPlayer = new VlcPlayer();
        }
    }

    @Override
    public void play(String filename) {
        if (mp4Player != null) {
            mp4Player.playMp4(filename);
        } else if (vlcPlayer != null) {
            vlcPlayer.playVlc(filename);
        }
    }
}

public class MediaAdapterPattern {
    public static void main(String[] args) {
        MediaPlayer mp3Player = new Mp3Player();
        mp3Player.play("song.mp3");

        MediaPlayer mediaAdapter = new MediaAdapter("mp4");
        mediaAdapter.play("movie.mp4");
    }
}
