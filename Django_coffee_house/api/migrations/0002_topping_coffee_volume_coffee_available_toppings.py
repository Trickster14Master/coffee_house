# Generated by Django 4.1 on 2022-08-27 06:16

from django.db import migrations, models
import django.db.models.deletion


class Migration(migrations.Migration):

    dependencies = [
        ('api', '0001_initial'),
    ]

    operations = [
        migrations.CreateModel(
            name='Topping',
            fields=[
                ('id', models.BigAutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
                ('name', models.TextField()),
                ('price', models.TextField()),
                ('volume', models.IntegerField()),
            ],
        ),
        migrations.AddField(
            model_name='coffee',
            name='volume',
            field=models.IntegerField(default=1),
            preserve_default=False,
        ),
        migrations.AddField(
            model_name='coffee',
            name='available_toppings',
            field=models.ForeignKey(null=True, on_delete=django.db.models.deletion.PROTECT, to='api.topping'),
        ),
    ]
