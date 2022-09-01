package Nobilities.ex15.musicJukebox;


import java.util.HashMap;
import java.util.Map;

public class SongList {

    private final Map<Number,Song> Songlists = new HashMap<>();


    public Song listen(int number){
        return Songlists.getOrDefault(number, new Song("no song"));
    }
    public void setSonglists(Number to, Song song) {
        Songlists.put(to, song);
    }

    public void listen(Number to, Song choseSong) {
    }
}
