package br.iesb.mobile.rpg_pi2_20211.ui.fragment.batalha

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import br.iesb.mobile.rpg_pi2_20211.R
import br.iesb.mobile.rpg_pi2_20211.databinding.FragmentMapBinding
import br.iesb.mobile.rpg_pi2_20211.ui.fragment.HomeFragment
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.GoogleMap.OnMarkerClickListener
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions


class MapFragment : Fragment(), OnMapReadyCallback {

    private lateinit var map: GoogleMap

    private lateinit var binding: FragmentMapBinding

//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
////        setContentView(R.layout.activity_main)
//
////        locationManager = getSystemService(Context.LOCATION_SERVICE) as LocationManager
//
//        // Recupera a instância do mapa configurado na atividade
//        val mapFragment: SupportMapFragment? = requireActivity().supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?
//
//        // Solicita a apresentação do mapa em background
//        mapFragment?.getMapAsync(this)
//    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentMapBinding.inflate(inflater,container,false)
        binding.fragment = this
        binding.lifecycleOwner = this


//      val mapFragment = requireActivity().supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment

        val mapFragment: SupportMapFragment? = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?
        mapFragment?.getMapAsync(this)

        return binding.root
    }

    override fun onMapReady(googleMap: GoogleMap) {

        map = googleMap

        val posicaoIESB = LatLng(-15.834963163926998, -47.91285006006427)
        val pinoIESB = MarkerOptions().position(posicaoIESB).title("IESB Campus Sul")
        map.addMarker(pinoIESB)


        val posicaoPARQUE = LatLng(-15.800343, -47.9078)
        val pinoPARQUE = MarkerOptions().position(posicaoPARQUE).title("PARQUE DA CIDADE")
        map.addMarker(pinoPARQUE)


        val posicaoLAGO = LatLng(-15.832551, -47.847669)
        val pinoLAGO = MarkerOptions().position(posicaoLAGO).title("LAGO PARANOÁ")
        map.addMarker(pinoLAGO)


            map.setOnMarkerClickListener {
                findNavController().navigate(R.id.action_mapFragment_to_batalhaFragment)
                return@setOnMarkerClickListener true
            }





        val posicaoBASILIA = LatLng(-15.7942287, -47.8821658)



        map.moveCamera(CameraUpdateFactory.newLatLngZoom(posicaoBASILIA, 8f))

    }


}



