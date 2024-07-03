package ru.itis.homework2

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import ru.itis.homework2.databinding.FragmentTrackBinding


class TrackFragment() : Fragment(R.layout.fragment_track) {
    private var binding: FragmentTrackBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentTrackBinding.bind(view)
        binding?.run {
            var id = arguments?.getInt("ID")
            var track = TrackRepository.tracks.find {
                a -> a.id == id
            }
            track?.let {
                trackName.text = it.trackName
                trackSinger.text = it.trackSinger
                Glide.with(view.context).load(it.imgURL).into(ivImage)
                textView3.text = it.description
            }
            goBack.setOnClickListener{
                findNavController().navigateUp()
            }
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}