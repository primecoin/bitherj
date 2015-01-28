package net.bither.bitherj.db;

import net.bither.bitherj.core.Address;
import net.bither.bitherj.core.HDMBId;
import net.bither.bitherj.core.HDMAddress;
import net.bither.bitherj.core.HDMKeychain;
import net.bither.bitherj.crypto.PasswordSeed;

import java.util.List;

public interface IAddressProvider {
    // password
    public boolean changePassword(CharSequence oldPassword, CharSequence newPassword);

    public PasswordSeed getPasswordSeed();

    public boolean hasPasswordSeed();

    //hd
    public List<Integer> getHDSeeds();

    public String getEncryptSeed(int hdSeedId);

    public String getEncryptHDSeed(int hdSeedId);

    public void updateEncryptHDSeed(int hdSeedId, String encryptHDSeed);

    public void setEncryptSeed(int hdSeedId, String encryptSeed, String encryptHDSeed);

    public boolean isHDSeedFromXRandom(int hdSeedId);

    public String getHDMFristAddress(int hdSeedId);

    public int addHDKey(String encryptSeed, String encryptHdSeed, String firstAddress, boolean isXrandom, String addressOfPS);

    public HDMBId getHDMBId();


    public void addHDMBId(HDMBId bitherId, String addressOfPS);

    public void changeHDBIdPassword(HDMBId hdmbId);

    public void changeHDMBIdPassword(String encryptBitherPassword);

    public List<HDMAddress> getHDMAddressInUse(HDMKeychain keychain);

    public void prepareHDMAddresses(int hdSeedId, List<HDMAddress.Pubs> pubs);

    public List<HDMAddress.Pubs> getUncompletedHDMAddressPubs(int hdSeedId, int count);

    public int maxHDMAddressPubIndex(int hdSeedId);//including completed and uncompleted

    public void recoverHDMAddresses(int hdSeedId, List<HDMAddress> addresses);


    public void completeHDMAddresses(int hdSeedId, List<HDMAddress> addresses);

    public void setHDMPubsRemote(int hdSeedId, int index, byte[] remote);

    public int uncompletedHDMAddressCount(int hdSeedId);

    public void syncComplete(int hdSeedId, int hdSeedIndex);


    //normal
    public List<Address> getAddresses();

    public String getEncryptPrivateKey(String address);

    public void addAddress(Address address);

    public void updatePrivateKey(String address, String encryptPriv);

    public void removeWatchOnlyAddress(Address address);

    public void trashPrivKeyAddress(Address address);

    public void restorePrivKeyAddress(Address address);

    public void updateSyncComplete(Address address);

}