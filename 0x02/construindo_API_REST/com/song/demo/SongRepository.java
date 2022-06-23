

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class SongRepository {
   private List<Song> list = new ArrayList<Song>();

   public List<Song> getAllSongs() {
    return list;
   }

   public Song getSongById(Integer id) {
	   Song songId = new Song(id, null, null, null, null);
	   return list.get(buscarPosicao(songId));
   }

   public void addSong(Song s) {
	   list.add(s);
   }

   public void updateSong(Song s) {
	   if(getSongById(s.getId()).equals(s)){
		   list.set(buscarPosicao(s), s);
	   }
   }

   public void removeSong(Song s) {
	   if(getSongById(s.getId()) != null) {
		   list.remove(buscarPosicao(s));
	   }
   }
   
   public int buscarPosicao(Song s) {
	   int valor = 0;
	   for(Song musica : list) {
		   if(musica.equals(s)) {
			   return valor;
		   }
		   valor++;
	   }
	   return valor;
   }

}
