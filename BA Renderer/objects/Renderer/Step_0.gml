/// @description Insert description here
// You can write your code in this editor
lastFrame=currentFrame
currentFrame=(audio_sound_get_track_position(aud)/audio_sound_length(snd_music))*array_length(texts)
show_debug_message("frame +"+string(abs(lastFrame-currentFrame)))
if(currentFrame>=array_length(texts))
{
	game_end()
}

var camSpeed=100
if(mouse_wheel_down())
{
	camera_set_view_size(view_camera[0],camera_get_view_width(view_camera[0])+camSpeed,camera_get_view_height(view_camera[0])+camSpeed)
	camera_set_view_pos(view_camera[0],camera_get_view_x(view_camera[0])-camSpeed/2,camera_get_view_y(view_camera[0])-camSpeed/2)
}
if(mouse_wheel_up())
{
	camera_set_view_size(view_camera[0],camera_get_view_width(view_camera[0])-camSpeed,camera_get_view_height(view_camera[0])-camSpeed)
	camera_set_view_pos(view_camera[0],camera_get_view_x(view_camera[0])+camSpeed/2,camera_get_view_y(view_camera[0])+camSpeed/2)
}