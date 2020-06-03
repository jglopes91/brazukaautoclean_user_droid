package com.blitzware.brazukacarcleanuser.ui.home

import android.Manifest
import android.annotation.SuppressLint
import android.content.pm.PackageManager
import android.location.Location
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.app.ActivityCompat
import androidx.core.app.ActivityCompat.finishAffinity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.blitzware.brazukacarcleanuser.R
import com.blitzware.brazukacarcleanuser.ui.adapters.ComapaniesHomeAdapter
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    private lateinit var fusedLocationClient: FusedLocationProviderClient
    private var RC_FINE_LOCATION = 130;

    private lateinit var companiesHomeAdapter: ComapaniesHomeAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(requireContext())
        requestRuntimeLocation()
        return root
    }

    private fun requestRuntimeLocation() {
        if (ActivityCompat.checkSelfPermission(
                requireContext(),
                Manifest.permission.ACCESS_FINE_LOCATION
            ) == PackageManager.PERMISSION_DENIED
            && ActivityCompat.checkSelfPermission(
                requireContext(),
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) == PackageManager.PERMISSION_DENIED
        ) {
            requestPermissions(
                arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
                RC_FINE_LOCATION
            )
        } else {
            getLatLong()
        }
    }

    @SuppressLint("MissingPermission")
    private fun getLatLong() {
        fusedLocationClient.lastLocation
            .addOnSuccessListener { location: Location? ->
                if (location != null) {
                    homeViewModel.getComapanies(location.latitude, location.longitude)
                        .observe(viewLifecycleOwner, Observer { data ->
                            if(null != data) {
                                companiesHomeAdapter =
                                    context?.let { ComapaniesHomeAdapter(it, data) }!!
                                rv_companies.adapter = companiesHomeAdapter
                                rv_companies.layoutManager = LinearLayoutManager(context)
                            }
                        })
                }
            }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        for (result in grantResults) {
            if (result == PackageManager.PERMISSION_GRANTED) {
                getLatLong()
            }
        }
    }
}