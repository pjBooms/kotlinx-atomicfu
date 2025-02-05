package kotlinx.atomicfu.locks

import kotlinx.cinterop.ExperimentalForeignApi
import platform.posix.*

@OptIn(ExperimentalForeignApi::class)
actual fun getCurrentThreadQoS(): String {
    val qosClass = qos_class_self()
    return when (qosClass) {
        QOS_CLASS_USER_INTERACTIVE -> "User Interactive"
        QOS_CLASS_USER_INITIATED -> "User Initiated"
        QOS_CLASS_DEFAULT -> "Default"
        QOS_CLASS_UTILITY -> "Utility"
        QOS_CLASS_BACKGROUND -> "Background"
        else -> "Unknown QoS Class: $qosClass"
    }
}