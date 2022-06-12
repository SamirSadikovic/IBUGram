package ba.ibu.gram.di

import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.functions.FirebaseFunctions
import com.google.firebase.functions.ktx.functions
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.ktx.storage
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
  @Singleton @Provides fun provideAuth(): FirebaseAuth = Firebase.auth
  @Singleton @Provides fun provideFunctions(): FirebaseFunctions = Firebase.functions
  @Singleton @Provides fun provideStorage(): FirebaseStorage = Firebase.storage
  @Singleton @Provides fun provideGson(): Gson = Gson()

}
