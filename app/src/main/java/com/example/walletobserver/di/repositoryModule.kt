package com.example.walletobserver.di

import com.example.walletobserver.repository.RecordRepository
import com.example.walletobserver.util.KOIN_RECODR_DAO
import com.example.walletobserver.util.KOIN_RECORD_REPO
import org.koin.core.qualifier.named
import org.koin.dsl.module

val repositoryModule = module {
  single(named(KOIN_RECORD_REPO)) { RecordRepository(get(named(KOIN_RECODR_DAO))) }
}