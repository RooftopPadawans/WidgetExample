package com.flknlabs.widgetexample

import android.app.PendingIntent
import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.widget.RemoteViews


class SimpleAppWidget: AppWidgetProvider() {

    override fun onUpdate(
        context: Context,
        appWidgetManager: AppWidgetManager,
        appWidgetIds: IntArray
    ) {
        for (appWidgetId in appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId)
        }
    }

    private fun updateAppWidget(
        context: Context, appWidgetManager: AppWidgetManager,
        appWidgetId: Int
    ) {

        // Construct the RemoteViews object
        val views = RemoteViews(context.packageName, R.layout.simple_app_widget)

        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("http://rooftop.dev/es"))
        val pendingIntent = PendingIntent.getActivity(context, 0, intent, 0)

        views.setOnClickPendingIntent(R.id.tvWidget, pendingIntent)

        appWidgetManager.updateAppWidget(appWidgetId, views)
    }
}