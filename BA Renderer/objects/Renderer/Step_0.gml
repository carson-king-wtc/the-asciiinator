/// @description Insert description here
// You can write your code in this editor
lastFrame=currentFrame
currentFrame=(audio_sound_get_track_position(aud)/audio_sound_length(snd_music))*array_length(texts)
show_debug_message("frame +"+string(abs(lastFrame-currentFrame)))
if(currentFrame>=array_length(texts))
{
	game_end()
}