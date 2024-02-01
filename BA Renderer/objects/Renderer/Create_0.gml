/// @description Insert description here
// You can write your code in this editor
frames=1000000
texts=[]
draw_set_color(c_black)
draw_set_font(fn_font)
currentFrame=0
for(var i=0;i<frames;i++)
{
	show_debug_message("loading save..."+string(i))
	var _file="C:/Users/carson/Documents/bad-apple-but-uhhhh/frame-ascii/frame"+string(i)+".txt"
	if(!file_exists(_file))
	{
		break;
	}
	else
	{
		array_push(texts,load_file(_file))
	}
}
aud=audio_play_sound(snd_music,1000,false)
big=true