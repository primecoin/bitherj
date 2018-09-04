package net.bither.bitherj.api;

import net.bither.bitherj.api.http.BitherUrl;
import net.bither.bitherj.api.http.HttpGetResponse;
import net.bither.bitherj.api.http.HttpsGetResponse;
import net.bither.bitherj.core.Block;
import net.bither.bitherj.utils.BlockUtil;

import net.bither.bitherj.utils.Utils;
import org.json.JSONException;
import org.json.JSONObject;

public class BlockChainGetLatestBlockApi extends HttpsGetResponse<Block> {
    public BlockChainGetLatestBlockApi() {
//        setUrl(BitherUrl.BLOCKCHAIN_INFO_GET_LASTST_BLOCK);
        setUrl("http://api.primecoin.org/rest/pcoin/syncblock");
    }

    @Override
    public void setResult(String response) throws Exception {
        JSONObject jsonObject = new JSONObject(response);

        JSONObject result = jsonObject.getJSONObject("result");


        this.result = formatStoreBlockFromBlockChainInfo(result);
//        this.result = BlockUtil.getLatestBlockHeight(result);
    }

    public static Block formatStoreBlockFromBlockChainInfo(JSONObject jsonObject)
            throws JSONException {
        long ver = jsonObject.getLong("version");
        int height = jsonObject.getInt("height");
        String prevBlock = jsonObject.getString("previousblockhash");
        String mrklRoot = jsonObject.getString("merkleroot");
        String hashCode = jsonObject.getString("hash");
        int time = jsonObject.getInt("time");
        String bits = jsonObject.getString("bits");
        long difficultyTarget = 389437975;//Long.parseLong(bits);
        long nonce = jsonObject.getLong("nonce");

        Block b = BlockUtil.getStoredBlock(ver, prevBlock, mrklRoot, time, difficultyTarget, nonce, height);
        b.setBlockHash(Utils.reverseBytes(Utils.hexStringToByteArray(hashCode)));

        return b;
    }
}
