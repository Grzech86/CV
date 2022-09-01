package Nobilities.ex15.musicJukebox;

public class Number {
    private final int number;

    public Number(int number) {this.number= number;}

    private Song choseSong() {
        return new Song("piosenka ");
    }

    public Song listen(SongList songList) {
        return songList.listen(this.number);
    }

    public void listen(SongList songList, Number to) {
        songList.listen(to, choseSong());
    }

}
