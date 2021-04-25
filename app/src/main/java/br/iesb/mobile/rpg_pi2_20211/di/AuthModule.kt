package br.iesb.mobile.rpg_pi2_20211.di

import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent :: class)
class AuthModule {

    @Provides
    fun firebaseAuthProvider() = Firebase.auth
}