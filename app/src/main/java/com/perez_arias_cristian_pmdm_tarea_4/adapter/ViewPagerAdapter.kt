package com.perez_arias_cristian_pmdm_tarea_4.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.perez_arias_cristian_pmdm_tarea_4.ColeccionablesFragment
import com.perez_arias_cristian_pmdm_tarea_4.MundosFragment
import com.perez_arias_cristian_pmdm_tarea_4.PersonajesFragment

class ViewPagerAdapter(activity: FragmentActivity) : FragmentStateAdapter(activity) {
    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> PersonajesFragment()
            1 -> MundosFragment()
            2 -> ColeccionablesFragment()
            else -> Fragment()
        }
    }
}
