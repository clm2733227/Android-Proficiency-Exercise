package yeungkc.com.gankio_for_android_proficiency_exercise.model.bean

import yeungkc.com.gankio_for_android_proficiency_exercise.ui.adapter.GankAdapter.Companion.GANK_PIC_TYPE
import yeungkc.com.gankio_for_android_proficiency_exercise.ui.adapter.GankAdapter.Companion.GANK_TYPE
import yeungkc.com.gankio_for_android_proficiency_exercise.ui.adapter.GankAdapter.Companion.GANK_VP_PIC_TYPE
import java.util.*


interface AutoBean {
    val itemType: Int
    val itemId: Long
}

open class BaseResult<T>(
        var error: Boolean,
        var results: T
)

open  class GankResult() : AutoBean {
    override val itemType: Int
        get() {
            if (images?.isEmpty() ?: true) {
                return GANK_TYPE
            } else {
                if (images!!.size > 1) {
                    return GANK_VP_PIC_TYPE
                } else {
                    return GANK_PIC_TYPE
                }
            }
        }

    override val itemId: Long
        get() = hashCode().toLong()

    lateinit var _id: String
    lateinit var publishedAt: Date
    lateinit var type: String
    lateinit var desc: String
    lateinit var url: String
    var who: String? = null
    var images: List<String>? = null

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other?.javaClass != javaClass) return false

        other as GankResult

        if (_id != other._id) return false

        return true
    }

    override fun hashCode(): Int {
        return _id.hashCode()
    }
}