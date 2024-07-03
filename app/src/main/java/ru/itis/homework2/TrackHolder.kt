package ru.itis.homework2

import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import ru.itis.homework2.databinding.ItemMusicBinding

class TrackHolder(
    private val glide : RequestManager,
    private val binding : ItemMusicBinding,
    private val click : (Int) -> Unit
): ViewHolder(binding.root) {
    fun onBind(track: Track){
        binding.run {
            trackName.text = track.trackName
            trackSinger.text = track.trackSinger
            glide.load(track.imgURL).into(ivImage)
            root.setOnClickListener{
                click(track.id)
            }
        }
    }
}