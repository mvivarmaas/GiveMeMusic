package me.mvivarmaas.givememusic.dao;

import com.wrapper.spotify.SpotifyApi;
import com.wrapper.spotify.model_objects.AbstractModelObject;
import com.wrapper.spotify.model_objects.specification.Album;
import com.wrapper.spotify.requests.data.albums.GetAlbumRequest;

/**
 * Use this class to get albums via the Spotify-Web-Api
 */
public class AlbumRequest implements ItemRequest{
    private SpotifyApi api;
    private String accessToken;
    private String albumId;

    protected AlbumRequest(SpotifyApi api, String accessToken, String albumId) {
        this.api = api;
        this.accessToken = accessToken;
        this.albumId = albumId;
    }

    @Override
    public AbstractModelObject get() {
        final GetAlbumRequest getAlbumRequest = api.getAlbum(albumId).build();
        try {
            final Album album = getAlbumRequest.execute();
            return (AbstractModelObject) album;
        } catch (Exception e) {
            System.out.println("Something went wrong! " + e.getMessage());
        }
        return null;
    }
}
