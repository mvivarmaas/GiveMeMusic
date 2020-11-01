package me.mvivarmaas.givememusic.dao;

import com.wrapper.spotify.SpotifyApi;

public class ItemRequestFactory {

    private String accessToken;

    public ItemRequestFactory(String accessToken) {
        this.accessToken = accessToken;
    }

    /**
     *
     * @param albumId != null, Spotify album Id
     * @return Album request object for the provided album
     */
    public AlbumRequest getAlbumRequest(String albumId) {
        SpotifyApi api = new SpotifyApi.Builder()
                .setAccessToken(accessToken)
                .build();
        return new AlbumRequest(api, accessToken, albumId);
    }



    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }
}
