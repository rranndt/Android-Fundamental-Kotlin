package com.kotlin.myunittesting

/**
 *@author Rizki Rian Anandita
 * Create By rizki
 */
class MainViewModel(private val cuboidModel: CuboidModel) {

    fun getrCircumference(): Double = cuboidModel.getCircumference()

    fun getSurfaceArea(): Double = cuboidModel.getSurfaceArea()

    fun getVolume(): Double = cuboidModel.getVolume()

    fun save(l: Double, w: Double, h: Double) {
        cuboidModel.save(l, w, h)
    }
}