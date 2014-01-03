
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

class MyPlayer {

    private var player: Player = null

    private var stream: BufferedInputStream = null


    def play(file: String): Unit =
    {
        stream = new BufferedInputStream((new FileInputStream(file)))
        player = new Player(stream)
        player.play()
    }


    def close(): Unit = {
        if (player != null) {
            player.close()
        }
        if (stream != null) {
            stream.close()
        }
    }
/*
    public static void main(String[] args) {
        MyPlayer player = new MyPlayer();
        try {
            player.play("furuki.mp3");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (JavaLayerException e) {
            e.printStackTrace();
        } finally {
            if (player != null) {
                try {
                    player.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
*/
}

object MyPlayer{
	def main(args: Array[String]): Unit = {
          val player: MyPlayer = new MyPlayer()
          try {
            player.play("furuki.mp3")
          } catch {
            case e: FileNotFoundException  =>
              e.printStackTrace()
            case e: JavaLayerException =>
              e.printStackTrace()
          } finally {
            if (player != null) {
                try {
                  player.close()
                } catch {case e: IOException  =>
                    e.printStackTrace()
                }
             }
         }
       }
}