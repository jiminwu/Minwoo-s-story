# Generated by Django 3.1.2 on 2020-10-30 00:31

from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ('voracay', '0006_auto_20201030_0926'),
    ]

    operations = [
        migrations.AlterField(
            model_name='logmettingchat',
            name='meeting_chat_url',
            field=models.CharField(max_length=128),
        ),
        migrations.AlterField(
            model_name='meeting',
            name='meeting_link',
            field=models.CharField(max_length=128),
        ),
    ]
