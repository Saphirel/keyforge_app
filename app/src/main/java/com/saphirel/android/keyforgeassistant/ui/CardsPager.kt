package com.saphirel.android.keyforgeassistant.ui

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.saphirel.android.keyforgeassistant.objects.House
import com.saphirel.android.keyforgeassistant.ui.listing.cards.ActionsFragment
import com.saphirel.android.keyforgeassistant.ui.listing.cards.ArtifactsFragment
import com.saphirel.android.keyforgeassistant.ui.listing.cards.CreaturesFragment
import com.saphirel.android.keyforgeassistant.ui.listing.cards.UpgradesFragment

class CardsPager internal constructor(fm: FragmentManager, house: House) : FragmentStatePagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    private val mFragmentList = arrayListOf<Fragment>(CreaturesFragment(house.creatures), ActionsFragment(house.actions), ArtifactsFragment(house.artifacts), UpgradesFragment(house.upgrades))
    private val mFragmentTitleList = arrayListOf("Creatures", "Actions", "Artefacts", "Upgrades")

    override fun getItem(position: Int): Fragment {
        return mFragmentList[position]
    }

    fun addFragment(fragment: Fragment, title: String) {
        mFragmentList.add(fragment)
        mFragmentTitleList.add(title)
    }

    /**
     * If you want to only show icons, return null from this method.
     * @param position
     * @return
     */
    override fun getPageTitle(position: Int): CharSequence? {
        return mFragmentTitleList[position]
    }

    override fun getCount(): Int {
        return mFragmentList.size
    }
}