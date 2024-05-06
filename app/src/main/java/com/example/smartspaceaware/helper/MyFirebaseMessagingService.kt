package com.example.smartspaceaware.helper

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.core.app.NotificationCompat
import com.example.smartspaceaware.Dummy
import com.example.smartspaceaware.R
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

const val chanelId = "spaceNotifcationChannel"
const val chanelName = "com.example.spacenotifcation"
class MyFirebaseMessagingService : FirebaseMessagingService(){

    override fun onMessageReceived(message: RemoteMessage) {
        super.onMessageReceived(message)
        createNotification(this, message)

    }
}

private fun createNotification(
    myFirebaseMessagingService: MyFirebaseMessagingService,
    message: RemoteMessage,
) {
    val intent = Intent(myFirebaseMessagingService.applicationContext, Dummy::class.java).apply {
            flags =  Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
    }

    val pendingIntent: PendingIntent = PendingIntent.getActivity(myFirebaseMessagingService.applicationContext, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE)

    val builder = NotificationCompat.Builder(myFirebaseMessagingService.applicationContext, chanelId).apply {
        setSmallIcon(R.drawable.ic_launcher_foreground)
        setContentTitle(message.notification!!.title.toString())
        setContentInfo(message.notification!!.body.toString())
        setStyle(NotificationCompat.BigTextStyle()
            .bigText(message.notification!!.body.toString()))
        setPriority(NotificationCompat.PRIORITY_HIGH)
        setOnlyAlertOnce(true)
        setAutoCancel(true)
        setContentIntent(pendingIntent)
        setVibrate(longArrayOf(1000, 1000, 1000, 1000))
    }

    val notificationManager = myFirebaseMessagingService.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
    if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
        val notificationChannel = NotificationChannel(chanelId, chanelName, NotificationManager.IMPORTANCE_HIGH)
        notificationManager.createNotificationChannel(notificationChannel)
    }
    notificationManager.notify(0, builder.build())
}