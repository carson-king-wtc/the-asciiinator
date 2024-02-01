/// @description Insert description here
// You can write your code in this editor
lastFrame=currentFrame
currentFrame=(audio_sound_get_track_position(aud)/(60*3+39))*array_length(texts)
show_debug_message("frame +"+string(abs(lastFrame-currentFrame)))
if(currentFrame>=array_length(texts))
{
	game_end()
}