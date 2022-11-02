package com.example.jetpackcomposecodelayoutsandnav

import androidx.compose.foundation.layout.* // ktlint-disable no-wildcard-imports
import androidx.compose.material.* // ktlint-disable no-wildcard-imports
import androidx.compose.runtime.* // ktlint-disable no-wildcard-imports
// ktlint-disable no-wildcard-imports
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.widget.FrameLayout
import androidx.compose.foundation.*
import androidx.compose.ui.graphics.*
import androidx.compose.ui.unit.*
import com.google.android.exoplayer2.*
import com.google.android.exoplayer2.Player.REPEAT_MODE_ONE
import com.imherrera.videoplayer.ResizeMode
import com.imherrera.videoplayer.VideoPlayer
import com.imherrera.videoplayer.VideoPlayerControl
import com.imherrera.videoplayer.rememberVideoPlayerState

@Composable
fun americanRecipeVideoOne() {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(250.dp)

    ) {

        val playerStates = rememberVideoPlayerState()

        VideoPlayer(
            playerState = playerStates,
            modifier = Modifier.fillMaxHeight().background(
                Color.Black
            ).fillMaxWidth().fillMaxSize()
        ) {

            VideoPlayerControl(
                state = playerStates,
                title = "",
            )
        }

        LaunchedEffect(Unit) {
            playerStates.player.setMediaItem(MediaItem.fromUri("https://player.vimeo.com/external/475026953.sd.mp4?s=bd12f4162ae01b61b8a22fd111ade38b88072b43&profile_id=164&oauth2_token_id=57447761"))
            playerStates.player.prepare()
            playerStates.player.playWhenReady = true
            playerStates.player.play()
            playerStates.player.repeatMode = REPEAT_MODE_ONE
            playerStates.control.setVideoResize(ResizeMode.Zoom)
        }
    }
}

@Composable
fun americanRecipeVideoTwo() {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(250.dp)
    ) {

        val playerStates = rememberVideoPlayerState()

        VideoPlayer(
            playerState = playerStates,
            modifier = Modifier.fillMaxHeight().fillMaxWidth().background(
                Color.Black
            )
        ) {
            VideoPlayerControl(
                state = playerStates,
                title = "",
            )
        }

        LaunchedEffect(Unit) {
            playerStates.player.setMediaItem(MediaItem.fromUri("https://player.vimeo.com/external/369238126.sd.mp4?s=bf39debe782e715eccc38132a83106e04dd827e3&profile_id=165&oauth2_token_id=57447761"))
            playerStates.player.prepare()
            playerStates.player.playWhenReady = true
            playerStates.player.play()
            playerStates.player.repeatMode = REPEAT_MODE_ONE
            playerStates.control.setVideoResize(ResizeMode.Fill)
            C.VIDEO_SCALING_MODE_SCALE_TO_FIT_WITH_CROPPING
            FrameLayout.LayoutParams(MATCH_PARENT, MATCH_PARENT)
        }
    }
}

@Composable
fun americanRecipeVideoThree() {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(250.dp)
    ) {

        val playerStates = rememberVideoPlayerState()

        VideoPlayer(
            playerState = playerStates,
            modifier = Modifier.fillMaxHeight().fillMaxWidth().background(
                Color.Black
            )
        ) {
            VideoPlayerControl(
                state = playerStates,
                title = "",
            )
        }

        LaunchedEffect(Unit) {
            playerStates.player.setMediaItem(MediaItem.fromUri("https://player.vimeo.com/external/433979984.sd.mp4?s=3edc1f6e0f3925c85406f40739b9706fb98b9548&profile_id=164&oauth2_token_id=57447761"))
            playerStates.player.prepare()
            playerStates.player.playWhenReady = true
            playerStates.player.play()
            playerStates.player.repeatMode = REPEAT_MODE_ONE
            playerStates.control.setVideoResize(ResizeMode.Fill)
            C.VIDEO_SCALING_MODE_SCALE_TO_FIT_WITH_CROPPING
            FrameLayout.LayoutParams(MATCH_PARENT, MATCH_PARENT)
        }
    }
}

@Composable
fun cajunRecipeVideoOne() {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(250.dp)
    ) {

        val playerStates = rememberVideoPlayerState()

        VideoPlayer(
            playerState = playerStates,
            modifier = Modifier.fillMaxHeight().fillMaxWidth().background(
                Color.Black
            )
        ) {
            VideoPlayerControl(
                state = playerStates,
                title = "",
            )
        }

        LaunchedEffect(Unit) {
            playerStates.player.setMediaItem(MediaItem.fromUri("https://player.vimeo.com/external/429267698.sd.mp4?s=9d3a57e05ca52a4c385ef346e6fa5b8a7576bcd4&profile_id=164&oauth2_token_id=57447761"))
            playerStates.player.prepare()
            playerStates.player.playWhenReady = true
            playerStates.player.play()
            playerStates.player.repeatMode = REPEAT_MODE_ONE
            playerStates.control.setVideoResize(ResizeMode.Fill)
            C.VIDEO_SCALING_MODE_SCALE_TO_FIT_WITH_CROPPING
            FrameLayout.LayoutParams(MATCH_PARENT, MATCH_PARENT)
        }
    }
}

@Composable
fun cajunRecipeVideoTwo() {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(250.dp)
    ) {

        val playerStates = rememberVideoPlayerState()

        VideoPlayer(
            playerState = playerStates,
            modifier = Modifier.fillMaxHeight().fillMaxWidth().background(
                Color.Black
            )
        ) {
            VideoPlayerControl(
                state = playerStates,
                title = "",
            )
        }

        LaunchedEffect(Unit) {
            playerStates.player.setMediaItem(MediaItem.fromUri("https://player.vimeo.com/external/371863140.sd.mp4?s=f66fd45c25e882c0ac9d7cd803a106a171399273&profile_id=164&oauth2_token_id=57447761"))
            playerStates.player.prepare()
            playerStates.player.playWhenReady = true
            playerStates.player.play()
            playerStates.player.repeatMode = REPEAT_MODE_ONE
            playerStates.control.setVideoResize(ResizeMode.Zoom)
            C.VIDEO_SCALING_MODE_SCALE_TO_FIT_WITH_CROPPING
            FrameLayout.LayoutParams(MATCH_PARENT, MATCH_PARENT)
        }
    }
}

@Composable
fun cajunRecipeVideoThree() {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(250.dp)
    ) {

        val playerStates = rememberVideoPlayerState()

        VideoPlayer(
            playerState = playerStates,
            modifier = Modifier.fillMaxHeight().fillMaxWidth().background(
                Color.Black
            )
        ) {
            VideoPlayerControl(
                state = playerStates,
                title = "",
            )
        }

        LaunchedEffect(Unit) {
            playerStates.player.setMediaItem(MediaItem.fromUri("https://player.vimeo.com/external/406157990.sd.mp4?s=01e6053dfe48c135acabe6e8239f066b3f5804b9&profile_id=164&oauth2_token_id=57447761"))
            playerStates.player.prepare()
            playerStates.player.playWhenReady = true
            playerStates.player.play()
            playerStates.player.repeatMode = REPEAT_MODE_ONE
            playerStates.control.setVideoResize(ResizeMode.Zoom)
            C.VIDEO_SCALING_MODE_SCALE_TO_FIT_WITH_CROPPING
            FrameLayout.LayoutParams(MATCH_PARENT, MATCH_PARENT)
        }
    }
}

@Composable
fun chineseRecipeVideoOne() {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(250.dp)
    ) {

        val playerStates = rememberVideoPlayerState()

        VideoPlayer(
            playerState = playerStates,
            modifier = Modifier.fillMaxHeight().fillMaxWidth().background(
                Color.Black
            )
        ) {
            VideoPlayerControl(
                state = playerStates,
                title = "",
            )
        }

        LaunchedEffect(Unit) {
            playerStates.player.setMediaItem(MediaItem.fromUri("https://player.vimeo.com/external/385267892.sd.mp4?s=df913889c04112fa8e04a6e42e4974d5a3e1e41f&profile_id=164&oauth2_token_id=57447761"))
            playerStates.player.prepare()
            playerStates.player.playWhenReady = true
            playerStates.player.play()
            playerStates.player.repeatMode = REPEAT_MODE_ONE
            playerStates.control.setVideoResize(ResizeMode.Zoom)
            C.VIDEO_SCALING_MODE_SCALE_TO_FIT_WITH_CROPPING
            FrameLayout.LayoutParams(MATCH_PARENT, MATCH_PARENT)
        }
    }
}

@Composable
fun chineseRecipeVideoTwo() {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(250.dp)
    ) {

        val playerStates = rememberVideoPlayerState()

        VideoPlayer(
            playerState = playerStates,
            modifier = Modifier.fillMaxHeight().fillMaxWidth().background(
                Color.Black
            )
        ) {
            VideoPlayerControl(
                state = playerStates,
                title = "",
            )
        }

        LaunchedEffect(Unit) {
            playerStates.player.setMediaItem(MediaItem.fromUri("https://player.vimeo.com/external/439745700.sd.mp4?s=cd2a7a1a275c4f6ede377f337ae80b7caba12978&profile_id=164&oauth2_token_id=57447761"))
            playerStates.player.prepare()
            playerStates.player.playWhenReady = true
            playerStates.player.play()
            playerStates.player.repeatMode = REPEAT_MODE_ONE
            playerStates.control.setVideoResize(ResizeMode.Zoom)
            C.VIDEO_SCALING_MODE_SCALE_TO_FIT_WITH_CROPPING
            FrameLayout.LayoutParams(MATCH_PARENT, MATCH_PARENT)
        }
    }
}

@Composable
fun chineseRecipevideoThree() {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(250.dp)
    ) {

        val playerStates = rememberVideoPlayerState()

        VideoPlayer(
            playerState = playerStates,
            modifier = Modifier.fillMaxHeight().fillMaxWidth().background(
                Color.Black
            )
        ) {
            VideoPlayerControl(
                state = playerStates,
                title = "",
            )
        }

        LaunchedEffect(Unit) {
            playerStates.player.setMediaItem(MediaItem.fromUri("https://player.vimeo.com/external/346526234.sd.mp4?s=e9ea9bd49cce94031cbb05ca4bcb1690a2a49e52&profile_id=164&oauth2_token_id=57447761"))
            playerStates.player.prepare()
            playerStates.player.playWhenReady = true
            playerStates.player.play()
            playerStates.player.repeatMode = REPEAT_MODE_ONE
            playerStates.control.setVideoResize(ResizeMode.Fill)
            C.VIDEO_SCALING_MODE_SCALE_TO_FIT_WITH_CROPPING
            FrameLayout.LayoutParams(MATCH_PARENT, MATCH_PARENT)
        }
    }
}

@Composable
fun italianRecipeVideoOne() {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(250.dp)
    ) {

        val playerStates = rememberVideoPlayerState()

        VideoPlayer(
            playerState = playerStates,
            modifier = Modifier.fillMaxHeight().fillMaxWidth().background(
                Color.Black
            )
        ) {
            VideoPlayerControl(
                state = playerStates,
                title = "",
            )
        }

        LaunchedEffect(Unit) {
            playerStates.player.setMediaItem(MediaItem.fromUri("https://player.vimeo.com/progressive_redirect/playback/731957495/rendition/540p/file.mp4?loc=external&oauth2_token_id=57447761&signature=29818283276feb484080825f0d4fc777735916d8ad7df8e9505f5e7cef1f5d76"))
            playerStates.player.prepare()
            playerStates.player.playWhenReady = true
            playerStates.player.play()
            playerStates.player.repeatMode = REPEAT_MODE_ONE
            playerStates.control.setVideoResize(ResizeMode.Fill)
            C.VIDEO_SCALING_MODE_SCALE_TO_FIT_WITH_CROPPING
            FrameLayout.LayoutParams(MATCH_PARENT, MATCH_PARENT)
        }
    }
}

@Composable
fun italianRecipeVideoTwo() {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(250.dp)
    ) {

        val playerStates = rememberVideoPlayerState()

        VideoPlayer(
            playerState = playerStates,
            modifier = Modifier.fillMaxHeight().fillMaxWidth().background(
                Color.Black
            )
        ) {
            VideoPlayerControl(
                state = playerStates,
                title = " ",
            )
        }

        LaunchedEffect(Unit) {
            playerStates.player.setMediaItem(MediaItem.fromUri("https://player.vimeo.com/external/405221696.sd.mp4?s=ae7134a4ecac25c5c5131751c9c775a20438eb2c&profile_id=165&oauth2_token_id=57447761"))
            playerStates.player.prepare()
            playerStates.player.playWhenReady = true
            playerStates.player.play()
            playerStates.player.repeatMode = REPEAT_MODE_ONE
            playerStates.control.setVideoResize(ResizeMode.Zoom)
            C.VIDEO_SCALING_MODE_SCALE_TO_FIT_WITH_CROPPING
            FrameLayout.LayoutParams(MATCH_PARENT, MATCH_PARENT)
        }
    }
}

@Composable
fun italianRecipeVideoThree() {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(250.dp)
    ) {

        val playerStates = rememberVideoPlayerState()

        VideoPlayer(
            playerState = playerStates,
            modifier = Modifier.fillMaxHeight().fillMaxWidth().background(
                Color.Black
            )
        ) {
            VideoPlayerControl(
                state = playerStates,
                title = " ",
            )
        }

        LaunchedEffect(Unit) {
            playerStates.player.setMediaItem(MediaItem.fromUri("https://player.vimeo.com/external/527809075.sd.mp4?s=9708d612b5a545ff689033a762c470fde91d9038&profile_id=165&oauth2_token_id=57447761"))
            playerStates.player.prepare()
            playerStates.player.playWhenReady = true
            playerStates.player.play()
            playerStates.player.repeatMode = REPEAT_MODE_ONE
            playerStates.control.setVideoResize(ResizeMode.Fill)
            C.VIDEO_SCALING_MODE_SCALE_TO_FIT_WITH_CROPPING
            FrameLayout.LayoutParams(MATCH_PARENT, MATCH_PARENT)
        }
    }
}

@Composable
fun mexicanRecipeVideoOne() {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(250.dp)
    ) {

        val playerStates = rememberVideoPlayerState()

        VideoPlayer(
            playerState = playerStates,
            modifier = Modifier.fillMaxHeight().fillMaxWidth().background(
                Color.Black
            )
        ) {
            VideoPlayerControl(
                state = playerStates,
                title = " ",
            )
        }

        LaunchedEffect(Unit) {
            playerStates.player.setMediaItem(MediaItem.fromUri("https://player.vimeo.com/external/311257229.sd.mp4?s=22110db9c12c59911fc20396a847bfdc40ee47cb&profile_id=164&oauth2_token_id=57447761"))
            playerStates.player.prepare()
            playerStates.player.playWhenReady = true
            playerStates.player.play()
            playerStates.player.repeatMode = REPEAT_MODE_ONE
            playerStates.control.setVideoResize(ResizeMode.Zoom)
            C.VIDEO_SCALING_MODE_SCALE_TO_FIT_WITH_CROPPING
            FrameLayout.LayoutParams(MATCH_PARENT, MATCH_PARENT)
        }
    }
}

@Composable
fun mexicanRecipeVideoTwo() {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(250.dp)
    ) {

        val playerStates = rememberVideoPlayerState()

        VideoPlayer(
            playerState = playerStates,
            modifier = Modifier.fillMaxHeight().fillMaxWidth().background(
                Color.Black
            )
        ) {
            VideoPlayerControl(
                state = playerStates,
                title = " ",
            )
        }

        LaunchedEffect(Unit) {
            playerStates.player.setMediaItem(MediaItem.fromUri("https://player.vimeo.com/external/372330413.sd.mp4?s=23a5e41a50d5980af8b383ee46a3c23c192a70fd&profile_id=164&oauth2_token_id=57447761"))
            playerStates.player.prepare()
            playerStates.player.playWhenReady = true
            playerStates.player.play()
            playerStates.player.repeatMode = REPEAT_MODE_ONE
            playerStates.control.setVideoResize(ResizeMode.Zoom)
            C.VIDEO_SCALING_MODE_SCALE_TO_FIT_WITH_CROPPING
            FrameLayout.LayoutParams(MATCH_PARENT, MATCH_PARENT)
        }
    }
}

@Composable
fun mexicanRecipeVideoThree() {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(250.dp)
    ) {

        val playerStates = rememberVideoPlayerState()

        VideoPlayer(
            playerState = playerStates,
            modifier = Modifier.fillMaxHeight().fillMaxWidth().background(
                Color.Black
            )
        ) {
            VideoPlayerControl(
                state = playerStates,
                title = " ",
            )
        }

        LaunchedEffect(Unit) {
            playerStates.player.setMediaItem(MediaItem.fromUri("https://player.vimeo.com/external/482108012.hd.mp4?s=f249e1f1bf061952fa3e52778502d74778ab581d&profile_id=174&oauth2_token_id=57447761"))
            playerStates.player.prepare()
            playerStates.player.playWhenReady = true
            playerStates.player.play()
            playerStates.player.repeatMode = REPEAT_MODE_ONE
            playerStates.control.setVideoResize(ResizeMode.Fill)
            C.VIDEO_SCALING_MODE_SCALE_TO_FIT_WITH_CROPPING
            FrameLayout.LayoutParams(MATCH_PARENT, MATCH_PARENT)
        }
    }
}
