// Script assets have changed for v2.3.0 see
// https://help.yoyogames.com/hc/en-us/articles/360005277377 for more information

function load_file(fname){
	try{
		if(file_exists(fname))
		{
			var _buffer = buffer_load(fname)
			var _string = buffer_read(_buffer,buffer_string)
			buffer_delete(_buffer)
		
			var _loadData = _string
			//show_debug_message("game LOADED DIAPER! "+string(_loadData))
			return _loadData;
		}
		else
		{
			return false;
		}
	}
	catch(e)
	{
		show_message("FAILED TO LOAD FUCK FUCK SHIT SHIT")
		return false
	}
}


