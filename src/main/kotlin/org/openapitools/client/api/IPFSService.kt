package org.openapitools.client.api

import org.openapitools.client.exception.APIException
import org.openapitools.client.infrastructure.PaginationSetting
import org.openapitools.client.infrastructure.SortOrder
import org.openapitools.client.models.ipfs.IPFSObject
import org.openapitools.client.models.ipfs.PinItem
import org.openapitools.client.models.ipfs.PinResponse
import java.io.File
import java.io.IOException

interface IPFSService {
    /**
     * Add a file to IPFS
     * You need to /ipfs/pin/add an object to avoid it being garbage collected. This usage is being counted in your user account quota.
     * @param file
     * @return IPFSObject
     */
    @Throws(APIException::class, IOException::class)
    fun add(file: File?): IPFSObject?

    /**
     * Relay to an IPFS gateway
     * Retrieve an object from the IFPS gateway (useful if you do not want to rely on a public gateway, such as &#x60;ipfs.blockfrost.dev&#x60;).
     * @param ipfsPath
     * @return Content as byte[]
     * @throws APIException
     */
    @Throws(APIException::class)
    operator fun get(ipfsPath: String?): ByteArray?

    /**
     * Pin an object
     * Pinned objects are counted in your user storage quota.
     * @param ipfsPath  (required)
     * @return PinResponse
     */
    @Throws(APIException::class)
    fun pinAdd(ipfsPath: String?): PinResponse?

    /**
     * List objects pinned to local storage
     * @param count The number of results displayed on one page.
     * @param page The page number for listing the results.
     * @param order The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last.
     * @return List&lt;PinItem&gt;
     */
    @Throws(APIException::class)
    fun getPinnedObjects(paging: PaginationSetting? = null): List<PinItem?>?

    /**
     * List objects pinned to local storage
     * @param order
     * @return List&lt;PinItem&gt;
     */
    @Throws(APIException::class)
    fun getAllPinnedObjects(order: SortOrder? = null): List<PinItem?>?

    /**
     *
     * List objects pinned to local storage
     * @param ipfsPath
     * @return PinItem
     */
    @Throws(APIException::class)
    fun getPinnedObjectByIpfsPath(ipfsPath: String?): PinItem?

    /**
     *
     * Remove pinned objects from local storage
     * @param ipfsPath
     * @return PinItem
     */
    @Throws(APIException::class)
    fun removePinnedObject(ipfsPath: String?): PinItem?
}