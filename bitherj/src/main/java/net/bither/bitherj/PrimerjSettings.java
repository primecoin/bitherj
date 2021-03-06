/*
 * Copyright 2014 http://Bither.net
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package net.bither.bitherj;

import net.bither.bitherj.utils.Utils;

import org.spongycastle.util.encoders.Hex;

import java.math.BigInteger;

public class PrimerjSettings {

    public static final boolean LOG_DEBUG = true;
    public static final boolean DEV_DEBUG = true;

    public static final int BITHER_DESKTOP_NETWORK_SOCKET = 8329;
    public static final int BITHER_ENTERPRISE_NETWORK_SOCKET = 8328;
    public static final int BITHER_DAEMON_NETWORK_SOCKET = 8327;

    public static final int PROTOCOL_VERSION = 70001;
    public static final int MIN_PROTO_VERSION = 70001;

    public static final int MAX_TX_SIZE = 100000;
    public static final int COMPRESS_OUT_NUM = 5;
    public static final int TX_PAGE_SIZE = 100;

    public static final String DONATE_ADDRESS = "ANTqRE6wpE2psbJvvMLJLixfCFms1zp61y";

    /**
     * The alert signing key originally owned by Satoshi, and now passed on to Gavin along with a few others.
     */
    public static final byte[] SATOSHI_KEY = Hex.decode("04fc9702847840aaf195de8442ebecedf5b095cdbb9bc716bda9110971b28a49e0ead8564ff0db22209e0374782c093bb899692d524e9d6a6956e7c5ecbcd68284");


    /**
     * The string returned by getId() for the main, production network where people trade things.
     */
    public static final String ID_MAINNET = "org.bitcoin.production";


    public static final BigInteger proofOfWorkLimit = Utils.decodeCompactBits(0x1d00ffffL);
    public static final int port = 9911;
    public static final int testNetPort = 9913;
    public static int getPort(){
        if(Utils.isTestNet()) return testNetPort;
        return port;
    }
    //    public static final int port = 8333;
    public static final long packetMagic = 0xe4e7e5e7L;
    public static final long testNetPacketMagic = 0xfbfecbc3L;
//    public static final long packetMagic = 0xf9beb4d9L;


    //    public static final int addressHeader = 0;
    public static final int addressHeader = 23;
    public static final int testNetAddressHeader = 111;

    public static final int btcAddressHeader = 0;
    public static final int btgAddressHeader = 38;
    public static final int btwAddressHeader = 73;
    public static final int btfAddressHeader = 36;
    public static final int btpAddressHeader = 56;

    public static final int p2shHeader = 83;
    public static final int testNetP2shHeader = 196;
    public static final int btcP2shHeader = 5;
    //    public static final int btgP2shHeader = 23;
    public static final int btgP2shHeader = 233;
    public static final int btwP2shHeader = 31;
    public static final int btfP2shHeader = 40;
    public static final int btpP2shHeader = 58;

    public static int getAddressHeader(NetType coinType) {
        switch (coinType) {
            case MAINNET: return addressHeader;
            case TESTNET: return testNetAddressHeader;
            case BITCOIN: return btcAddressHeader;
            default: return addressHeader;
        }
    }

    public static int getP2shHeader(NetType coinType) {
        switch (coinType) {
            case MAINNET: return p2shHeader;
            case TESTNET: return testNetP2shHeader;
            case BITCOIN: return btcP2shHeader;
            default: return p2shHeader;
        }
    }

    public static int getDumpedPrivateKeyHeader(NetType coinType) {
        return (128 + getAddressHeader(coinType));
    }

    public static long getPacketMagic() {
        if(Utils.isTestNet()) return testNetPacketMagic;
        else return packetMagic;
    }

    public static final int TARGET_TIMESPAN = 14 * 24 * 60 * 60;  // legacy bitcoin: 2 weeks per difficulty cycle, on average.
    public static final int TARGET_SPACING = 1 * 60;  // primecoin block spacing
    public static final int BLOCK_DIFFICULTY_INTERVAL = 2016; // legacy bitcoin
    public static final int INTERVAL = BLOCK_DIFFICULTY_INTERVAL;

    public static final long TX_UNCONFIRMED = Long.MAX_VALUE;

    public static final int PROTOCOL_TIMEOUT = 30000;

    public static final String id = ID_MAINNET;

    /**
     * The depth of blocks required for a coinbase transaction to be spendable.
     */
    public static final int spendableCoinbaseDepth = 100;
    public static final String[] dnsSeeds = new String[]{
            "seed.primecoin.org"
//            "103.84.87.82"
//            "192.168.1.7"
//             "seed.ppcoin.net"
            /*"primecoin.net",        // Pieter Wuille
            "103.84.87.82",         // Matt Corallo
            "xpm.altcointech.net",       // Chris Decker
            "dnsseed.xpm.altcointech.net", //no
            "xpm2.altcointech.net",   //no
            "dnsseed.xpm2.altcointech.net",  //no
            "primeseed.muuttuja.org",//   24
            */
    };

    public static final long MAX_MONEY = 21000000l * 100000000l;

    //    public static final byte[] GENESIS_BLOCK_HASH = Utils.reverseBytes(Hex.decode("000000000019d6689c085ae165831e934ff763ae46a2a6c172b3f1b60a8ce26f"));
    public static final byte[] GENESIS_BLOCK_HASH = Utils.reverseBytes(Hex.decode("963d17ba4dc753138078a2f56afb3af9674e2546822badff26837db9a0152106"));

    public static final int BITCOIN_REFERENCE_BLOCK_HEIGHT = 250000;
    public static final int MaxPeerConnections = 6;
    public static final int MaxPeerBackgroundConnections = 2;

    public static enum AppMode {
        COLD, HOT
    }

    public static enum ApiConfig {
        BLOCKCHAIN_INFO(1), BITHER_NET(0);

        private int value;

        ApiConfig(int value) {
            this.value = value;
        }

        public int value() {
            return value;
        }
    }

    public static final String PRIVATE_KEY_FILE_NAME = "%s/%s.key";
    public static final String WATCH_ONLY_FILE_NAME = "%s/%s.pub";

    public static final boolean ensureMinRequiredFee = true;

    public enum NetType {
        MAINNET(24), TESTNET(1), BITCOIN(0); // BIP44 coin type

        private int coinType;

        NetType(int coinType) {
            this.coinType = coinType;
        }

        public int getNetType() {
            return coinType;
        }
    }

    public enum TransactionFeeMode {
        // Transaction fee rate per kB
        Normal(100000000), High(200000000), Higher(500000000);

        private int satoshi;

        TransactionFeeMode(int satoshi) {
            this.satoshi = satoshi;
        }

        public int getFeeRateSatoshiPerKB() {
            return satoshi;
        }
    }

    public enum TransactionFeePrecision {
        P0(100000000), P1(10000000), P2(1000000), P3(100000);

        private int precision;

        TransactionFeePrecision(int precision) {
            this.precision = precision;
        }

        public int getPrecision() {
            return precision;
        }
    }

    public enum MarketType {
        COINGECKO ;
    }

    public static MarketType getMarketType(int value) {

        return MarketType.COINGECKO;
    }

    public static int getMarketValue(MarketType marketType) {
        return 1;
    }

    public static boolean validAddressPrefixPubkey(int pubkey) {
        if (pubkey == PrimerjSettings.getAddressHeader(Utils.getNetType())) {
            return true;
        }
        return false;
    }

    public static boolean validAddressPrefixScript(int script) {
        if (script == PrimerjSettings.getP2shHeader(Utils.getNetType())) {
            return true;
        }
        return false;
    }

    public enum KlineTimeType {
        ONE_MINUTE(1), FIVE_MINUTES(5), ONE_HOUR(60), ONE_DAY(1440);
        private int mVal;

        private KlineTimeType(int val) {
            this.mVal = val;
        }

        public int getValue() {
            return this.mVal;
        }
    }


}
