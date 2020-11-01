package me.mvivarmaas.givememusic.dao;

import com.wrapper.spotify.SpotifyApi;
import com.wrapper.spotify.model_objects.specification.Album;
import com.wrapper.spotify.requests.data.albums.GetAlbumRequest;

/**
 * Use this class to get albums via the Spotify-Web-Api
 */
public class AlbumRequest {
    private String accessToken;;
    private SpotifyApi api;
    private String albumId;

    public AlbumRequest(String accessToken, String albumId) {
        this.albumId = albumId;
        this.accessToken = accessToken;
        api = new SpotifyApi.Builder()
                .setAccessToken(this.accessToken)
                .build();

    }

    final GetAlbumRequest getAlbumRequest = api.getAlbum(albumId).build();

    public Album getAlbum_Sync() {
        try {
            final Album album = getAlbumRequest.execute();
            return album;
        } catch (Exception e) {
            System.out.println("Something went wrong! " + e.getMessage());
            return null;
        }
    }

}
