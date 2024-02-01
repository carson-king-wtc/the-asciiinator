/// @description Insert description here
// You can write your code in this editor
draw_set_halign(fa_center)
draw_set_valign(fa_middle)
if(!big)
{
	draw_text(room_width/2,room_height/2,texts[currentFrame])
}
else
{
	draw_text_transformed(room_width/2,room_height/2,texts[currentFrame],0.2,0.1,0)
}